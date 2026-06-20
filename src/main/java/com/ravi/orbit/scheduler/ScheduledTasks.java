package com.ravi.orbit.scheduler;

import com.ravi.orbit.repository.RefreshTokenRepository;
import com.ravi.orbit.service.IEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class ScheduledTasks {

//    private final IEmailService emailService;

    private final RefreshTokenRepository refreshTokenRepository;

//    public void sendEmailVerification() {
//
//    }
//
//    public void sendPasswordResetEmail() {
//
//    }
//
//    public void sendEmailReminder() {
//
//    }
//
//    public void sendEmailNotification() {
//
//    }

    @Scheduled(cron = "0 0 0 * * 1")
    public void clearExpiredSessions() {
        refreshTokenRepository.deleteByExpiryDateBefore(LocalDateTime.now());
        log.info("Expired sessions cleared");
    }

}
