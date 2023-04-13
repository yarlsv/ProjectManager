CREATE TABLE IF NOT EXISTS task
(
    id                  uuid DEFAULT gen_random_uuid()  NOT NULL,
    name                VARCHAR                         NOT NULL,
    status              VARCHAR                         NOT NULL,
    creation_date       DATE                            NOT NULL,
    change_status_date  DATE                            NOT NULL,
    information         VARCHAR                         NOT NULL,
    project_id          uuid                            NOT NULL

    CONSTRAINT pk_task PRIMARY KEY (id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);