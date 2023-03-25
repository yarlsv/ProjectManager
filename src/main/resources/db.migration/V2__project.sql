CREATE TABLE IF NOT EXISTS project
(
    id              uuid DEFAULT gen_random_uuid()      NOT NULL,
    name            varchar                             NOT NULL,
    task_list       UUID
    CONSTRAINT pk_project PRIMARY KEY (id),
    FOREIGN KEY (task_list) REFERENCES task(id)
);