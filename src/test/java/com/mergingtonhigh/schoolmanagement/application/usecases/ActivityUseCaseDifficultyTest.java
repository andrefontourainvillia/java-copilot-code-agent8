package com.mergingtonhigh.schoolmanagement.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mergingtonhigh.schoolmanagement.application.dtos.ActivityDTO;
import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.repositories.ActivityRepository;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ActivityType;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.DifficultyLevel;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ScheduleDetails;
import com.mergingtonhigh.schoolmanagement.presentation.mappers.ActivityMapper;

/**
 * Unit tests for ActivityUseCase difficulty filtering functionality.
 */
@ExtendWith(MockitoExtension.class)
class ActivityUseCaseDifficultyTest {

    @Mock
    private ActivityRepository activityRepository;

    private ActivityMapper activityMapper;
    private ActivityUseCase activityUseCase;

    @BeforeEach
    void setUp() {
        activityMapper = new ActivityMapper();
        activityUseCase = new ActivityUseCase(activityRepository, activityMapper);
    }

    @Test
    void shouldFilterByBeginnerDifficulty() {
        // Arrange
        Activity beginnerActivity = createTestActivity("Básico de Xadrez", DifficultyLevel.BEGINNER);
        Activity intermediateActivity = createTestActivity("Xadrez Intermediário", DifficultyLevel.INTERMEDIATE);
        Activity allLevelsActivity = createTestActivity("Xadrez para Todos", null);

        when(activityRepository.findAll()).thenReturn(Arrays.asList(
                beginnerActivity, intermediateActivity, allLevelsActivity));

        // Act
        Map<String, ActivityDTO> result = activityUseCase.getActivities(null, null, null, "beginner");

        // Assert
        assertEquals(1, result.size());
        assertTrue(result.containsKey("Básico de Xadrez"));
    }

    @Test
    void shouldFilterByIntermediateDifficulty() {
        // Arrange
        Activity beginnerActivity = createTestActivity("Básico de Xadrez", DifficultyLevel.BEGINNER);
        Activity intermediateActivity = createTestActivity("Xadrez Intermediário", DifficultyLevel.INTERMEDIATE);
        Activity allLevelsActivity = createTestActivity("Xadrez para Todos", null);

        when(activityRepository.findAll()).thenReturn(Arrays.asList(
                beginnerActivity, intermediateActivity, allLevelsActivity));

        // Act
        Map<String, ActivityDTO> result = activityUseCase.getActivities(null, null, null, "intermediate");

        // Assert
        assertEquals(1, result.size());
        assertTrue(result.containsKey("Xadrez Intermediário"));
    }

    @Test
    void shouldFilterByAdvancedDifficulty() {
        // Arrange
        Activity beginnerActivity = createTestActivity("Básico de Xadrez", DifficultyLevel.BEGINNER);
        Activity advancedActivity = createTestActivity("Xadrez Avançado", DifficultyLevel.ADVANCED);
        Activity allLevelsActivity = createTestActivity("Xadrez para Todos", null);

        when(activityRepository.findAll()).thenReturn(Arrays.asList(
                beginnerActivity, advancedActivity, allLevelsActivity));

        // Act
        Map<String, ActivityDTO> result = activityUseCase.getActivities(null, null, null, "advanced");

        // Assert
        assertEquals(1, result.size());
        assertTrue(result.containsKey("Xadrez Avançado"));
    }

    @Test
    void shouldFilterByAllLevels() {
        // Arrange
        Activity beginnerActivity = createTestActivity("Básico de Xadrez", DifficultyLevel.BEGINNER);
        Activity intermediateActivity = createTestActivity("Xadrez Intermediário", DifficultyLevel.INTERMEDIATE);
        Activity allLevelsActivity = createTestActivity("Xadrez para Todos", null);

        when(activityRepository.findAll()).thenReturn(Arrays.asList(
                beginnerActivity, intermediateActivity, allLevelsActivity));

        // Act - "all" should show only activities without difficulty specified
        Map<String, ActivityDTO> result = activityUseCase.getActivities(null, null, null, "all");

        // Assert
        assertEquals(1, result.size());
        assertTrue(result.containsKey("Xadrez para Todos"));
    }

    @Test
    void shouldReturnAllActivitiesWhenNoDifficultyFilter() {
        // Arrange
        Activity beginnerActivity = createTestActivity("Básico de Xadrez", DifficultyLevel.BEGINNER);
        Activity intermediateActivity = createTestActivity("Xadrez Intermediário", DifficultyLevel.INTERMEDIATE);
        Activity allLevelsActivity = createTestActivity("Xadrez para Todos", null);

        when(activityRepository.findAll()).thenReturn(Arrays.asList(
                beginnerActivity, intermediateActivity, allLevelsActivity));

        // Act
        Map<String, ActivityDTO> result = activityUseCase.getActivities(null, null, null, null);

        // Assert
        assertEquals(3, result.size());
        assertTrue(result.containsKey("Básico de Xadrez"));
        assertTrue(result.containsKey("Xadrez Intermediário"));
        assertTrue(result.containsKey("Xadrez para Todos"));
    }

    @Test
    void shouldReturnAllActivitiesForInvalidDifficultyFilter() {
        // Arrange
        Activity beginnerActivity = createTestActivity("Básico de Xadrez", DifficultyLevel.BEGINNER);
        Activity intermediateActivity = createTestActivity("Xadrez Intermediário", DifficultyLevel.INTERMEDIATE);

        when(activityRepository.findAll()).thenReturn(Arrays.asList(beginnerActivity, intermediateActivity));

        // Act
        Map<String, ActivityDTO> result = activityUseCase.getActivities(null, null, null, "invalid");

        // Assert
        assertEquals(2, result.size());
    }

    private Activity createTestActivity(String name, DifficultyLevel difficultyLevel) {
        ScheduleDetails schedule = new ScheduleDetails(
                List.of("Monday"),
                LocalTime.of(15, 30),
                LocalTime.of(17, 0));

        return new Activity(
                name,
                "Descrição de teste",
                "Seg 15:30-17:00",
                schedule,
                12,
                ActivityType.ACADEMIC,
                difficultyLevel);
    }
}