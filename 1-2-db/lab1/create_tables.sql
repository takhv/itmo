BEGIN;

create table lighting(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    lightlvl INT NOT NULL
);

create table location(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    lighting_id INT REFERENCES lighting(id),
    coords POINT
);

create table emotion(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20)
);

CREATE TABLE effect(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20)
);

CREATE TABLE eyes(
    id SERIAL PRIMARY KEY,
    color VARCHAR(20) NOT NULL default 'brown'
);

CREATE TABLE eyes_effect(
    id BIGSERIAL PRIMARY KEY,
    effect_id INT NOT NULL REFERENCES effect,
    eyes_id INT NOT NULL REFERENCES eyes,
    UNIQUE(effect_id, eyes_id)
);

create table human(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    sex VARCHAR(1) NOT NULL,
    location_id INT NOT NULL REFERENCES location(id),
    eyes_id INT NOT NULL REFERENCES eyes(id)
);

create table pitecantrop(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    sex VARCHAR(1) NOT NULL,
    location_id INT NOT NULL REFERENCES location(id),
    eyes_id INT NOT NULL REFERENCES eyes(id)
);

create table feel_emotions(
    id BIGSERIAL PRIMARY KEY,
    emotion_id INT NOT NULL REFERENCES emotion,
    pitecantrop_id INT NOT NULL REFERENCES pitecantrop,
);

COMMIT;
