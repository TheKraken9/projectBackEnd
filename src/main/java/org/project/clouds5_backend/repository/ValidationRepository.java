package org.project.clouds5_backend.repository;

import org.project.clouds5_backend.model.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation, String> {
}
