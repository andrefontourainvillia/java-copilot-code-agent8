package com.mergingtonhigh.schoolmanagement.domain.valueobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for DifficultyLevel value object.
 */
class DifficultyLevelTest {

    @Test
    void shouldHaveCorrectLabelsForAllLevels() {
        // Assert
        assertEquals("Iniciante", DifficultyLevel.BEGINNER.getLabel());
        assertEquals("Intermediário", DifficultyLevel.INTERMEDIATE.getLabel());
        assertEquals("Avançado", DifficultyLevel.ADVANCED.getLabel());
    }

    @Test
    void shouldHaveCorrectEnumNames() {
        // Assert
        assertEquals("BEGINNER", DifficultyLevel.BEGINNER.name());
        assertEquals("INTERMEDIATE", DifficultyLevel.INTERMEDIATE.name());
        assertEquals("ADVANCED", DifficultyLevel.ADVANCED.name());
    }

    @Test
    void shouldHaveAllThreeLevels() {
        // Assert
        assertEquals(3, DifficultyLevel.values().length);
    }
}