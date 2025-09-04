package com.mergingtonhigh.schoolmanagement.infrastructure.migrations;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ActivityType;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ScheduleDetails;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

/**
 * Adds the Manga Maniacs club to the extracurricular activities.
 * This migration adds the missing club that was recently announced.
 */
@ChangeUnit(id = "add-manga-maniacs-club", order = "002", author = "Andre Fontoura")
public class V002_AddMangaManiacsClub {

        private final MongoTemplate mongoTemplate;

        public V002_AddMangaManiacsClub(MongoTemplate mongoTemplate) {
                this.mongoTemplate = mongoTemplate;
        }

        @Execution
        public void migrate() {
                // Add Manga Maniacs club
                Activity mangaManiacs = new Activity(
                                "Manga Maniacs",
                                "Mergulhe no universo épico dos mangás! Descubra heróis lendários, vilões icônicos e aventuras inesquecíveis que conquistaram o mundo. Compartilhe teorias, debata enredos e explore os segredos por trás das obras-primas japonesas que emocionam milhões de fãs!",
                                "Terças-feiras, 19:00 - 20:30",
                                new ScheduleDetails(List.of("Tuesday"), LocalTime.of(19, 0), LocalTime.of(20, 30)),
                                15,
                                ActivityType.ARTS);
                mongoTemplate.save(mangaManiacs);
        }

        @RollbackExecution
        public void rollback() {
                // Remove Manga Maniacs club
                mongoTemplate.remove(new Query(Criteria.where("name").is("Manga Maniacs")), Activity.class);
        }
}