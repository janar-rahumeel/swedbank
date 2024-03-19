INSERT INTO PLAYGROUND (ID, NAME)
VALUES (1, 'Playground name 1');

INSERT INTO PLAY_SITE (ID, PLAYGROUND_ID, NAME, MAXIMUM_KID_VISITING_COUNT)
VALUES (1, 1, 'Play site name 1', 1);

INSERT INTO ATTRACTION (ID, PLAY_SITE_ID, SERIAL_NUMBER, TYPE)
VALUES (1, 1, 'SSR12L5', 'SLIDE');

INSERT INTO KID (ID, NAME, AGE, TICKET_NUMBER)
VALUES (1, 'Janar 1', 41, 'TIC336');

INSERT INTO KID (ID, NAME, AGE, TICKET_NUMBER)
VALUES (2, 'Janar 2', 41, 'TIC337');

INSERT INTO KID (ID, NAME, AGE, TICKET_NUMBER)
VALUES (3, 'Janar 3', 41, 'TIC338');

INSERT INTO KID_PLAY_SITE_VISIT (ID, KID_ID, PLAY_SITE_ID, STATUS, START_AT, END_AT)
VALUES (1, 1, 1, 'PLAYING', '2024-03-19 14:09:30', '2024-03-19 15:09:30');

INSERT INTO KID_PLAY_SITE_VISIT (ID, KID_ID, PLAY_SITE_ID, STATUS, START_AT, END_AT)
VALUES (2, 2, 1, 'WAITING', '2024-03-19 14:09:30', '2024-03-19 15:09:30');

INSERT INTO KID_PLAY_SITE_VISIT (ID, KID_ID, PLAY_SITE_ID, STATUS, START_AT, END_AT)
VALUES (3, 3, 1, 'PLAYING', '2024-03-18 14:09:30', '2024-03-18 15:09:30');