package com.perez.portfolio.controller;

import com.perez.portfolio.dto.PortfolioDTO;
import com.perez.portfolio.model.AuthRequest;
import com.perez.portfolio.model.AuthResponse;
import com.perez.portfolio.security.JwtUtil;
import com.perez.portfolio.service.about.AboutService;
import com.perez.portfolio.service.education.EducationService;
import com.perez.portfolio.service.experience.ExperienceService;
import com.perez.portfolio.service.home.HomeService;
import com.perez.portfolio.service.portfolioUser.PortfolioUserService;
import com.perez.portfolio.service.project.ProjectService;
import com.perez.portfolio.service.skill.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "https://my-portfolio-65acc.web.app/", maxAge = 3600)
public class PortfolioController {
    // === PORTFOLIO ====
    @Autowired
    HomeService homeService;
    @Autowired
    AboutService aboutService;
    @Autowired
    SkillService skillService;
    @Autowired
    EducationService educationService;
    @Autowired
    ExperienceService experienceService;
    @Autowired
    ProjectService projectService;

    @GetMapping(path = "/portfolio/get")
    public PortfolioDTO getPortfolio() {
        return new PortfolioDTO(
            homeService.getHome(),
            aboutService.getAbout(),
            skillService.getHardSkills(),
            skillService.getSoftSkills(),
            educationService.getAll(),
            experienceService.getAll(),
            projectService.getAll());
        }
    // === END PORTFOLIO ====
            
    // === LOGIN/AUTHENTICATION ===
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PortfolioUserService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping(path = "/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authReq) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authReq.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }
    // === END LOGIN/AUTHENTICATION ===
}
