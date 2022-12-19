CREATE TABLE IF NOT EXISTS skills(
      skill_id SERIAL PRIMARY KEY,
      name VARCHAR(20) NOT NULL UNIQUE,
      skill_status VARCHAR(10) NOT NULL
    );

CREATE TABLE IF NOT EXISTS specialties(
     specialty_id SERIAL PRIMARY KEY,
     name VARCHAR(20) NOT NULL UNIQUE,
     specialty_status VARCHAR(10) NOT NULL
    );

CREATE TABLE IF NOT EXISTS developers(
    developer_id SERIAL PRIMARY KEY,
    firstname VARCHAR (30) NOT NULL,
    lastname VARCHAR (30) NOT NULL,
    specialty_id INTEGER, FOREIGN KEY (specialty_id) REFERENCES specialties,
    developer_status VARCHAR(10) NOT NULL
    );


CREATE TABLE IF NOT EXISTS skills_atribute(
    developer_id INTEGER NOT NULL,
    skill_id INTEGER NOT NULL,
    PRIMARY KEY (developer_id, skill_id),
    UNIQUE (developer_id, skill_id),
    CONSTRAINT fk_developer_skill_id
    FOREIGN KEY (developer_id) REFERENCES developers (developer_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_skill_developer_id
    FOREIGN KEY (skill_id) REFERENCES skills (skill_id) ON DELETE CASCADE ON UPDATE CASCADE
    );