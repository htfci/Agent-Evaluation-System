package dev.htfci.server.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


@Entity()
@Table(name = "runs")
public class RunEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JdbcTypeCode(SqlTypes.JSON) // (java side) -> deserialize JSON back into Java object when pulling out of DB
    @Column(columnDefinition = "jsonb") // (postgres side) -> store this JSON data by using jsonb binary format
    private RunInput input;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private RunOutput output;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata", columnDefinition = "jsonb")
    private RunMetaData metaData;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private UserEntity user;

    public RunEntity() {}
}

