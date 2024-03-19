INSERT INTO PLAYGROUND (ID, NAME)
VALUES (3, 'Playground name 3');

INSERT INTO PLAY_SITE (ID, PLAYGROUND_ID, NAME, MAXIMUM_KID_VISITING_COUNT)
VALUES (3, 3, 'Play site name 3', 2);

INSERT INTO ATTRACTION (ID, PLAY_SITE_ID, SERIAL_NUMBER, TYPE)
VALUES (3, 3, 'SSR12L5', 'SLIDE');

INSERT INTO KID (ID, NAME, AGE, TICKET_NUMBER)
VALUES (3, 'Janar 1', 41, 'TIC336');

INSERT INTO KID (ID, NAME, AGE, TICKET_NUMBER)
VALUES (4, 'Janar 2', 41, 'TIC337');

INSERT INTO KID_PLAY_SITE_VISIT (ID, KID_ID, PLAY_SITE_ID, STATUS, START_AT)
VALUES (3, 3, 3, 'PLAYING', NOW());

INSERT INTO KID_PLAY_SITE_VISIT (ID, KID_ID, PLAY_SITE_ID, STATUS, START_AT)
VALUES (4, 4, 3, 'PLAYING', NOW());