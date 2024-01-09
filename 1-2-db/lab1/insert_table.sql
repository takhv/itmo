INSERT INTO emotion (id, name) VALUES (1, 'scare');
INSERT INTO emotion (id, name) VALUES (2, 'helplessness');
INSERT INTO effect (id, name) VALUES (1, 'night vision');
INSERT INTO effect (id, name) VALUES (2, 'blind');
INSERT INTO eyes (id, color) VALUES (1, 'blue');
INSERT INTO eyes (id, color) VALUES (2, 'brown');
INSERT INTO eyes (id, color) VALUES (3, 'brown');
insert into eyes_effect (id, effect_id, eyes_id) values (1, 1, 1);
insert into eyes_effect (id, effect_id, eyes_id) values (2, 2, 3);
insert into lighting (id, name, lightlvl) values (1, 'torch', 5);
insert into lighting (id, name, lightlvl) values (2, 'moon light', 8);
insert into location (id, name, lighting_id, coords) values (1, 'cave', 2, POINT(1,1));
insert into human (id, name, sex, location_id, eyes_id) values (1, 'author', 'm', 1, 1);
insert into human (id, name, sex, location_id, eyes_id) values (2, 'humanus', 'f', 1, 2);
insert into pitecantrop (id, name, sex, location_id, eyes_id) values (1, 'abu', 'm', 1, 3);
insert into feel_emotions (id, emotion_id, pitecantrop_id) values (1, 1, 1);
