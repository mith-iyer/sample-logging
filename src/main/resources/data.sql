INSERT INTO speaker (first_name, last_name, email_address) VALUES
  ('Ferenc', 'Kurai', 'ferenc.kurai@oracle.com'),
  ('Bernat', 'Fold', 'bernat.fold@oracle.com'),
  ('Brij', 'Pandey', 'brij.pandey@oracle.com'),
  ('Mithilesh', 'Iyer', 'mithilesh.iyer@oracle.com');

INSERT INTO attendee (first_name, last_name, email_address) VALUES
  ('Zoe','Schamberger','manley.swaniawski@example.com'),
  ('Duncan','Pfeffer','okuneva.justina@example.org'),
  ('Lenore','Rolfson','sylvan.cummings@example.net'),
  ('Gretchen','Strosin','schuyler.franecki@example.org'),
  ('Eunice','Sawayn','mbergnaum@example.net'),
  ('Luz','Lockman','schumm.louie@example.org'),
  ('Federico','Rowe','olga59@example.org'),
  ('Dejah','Kshlerin','eleanora.braun@example.net'),
  ('Odessa','Yundt','heathcote.maryjane@example.org'),
  ('Lowell','Bogisich','wiegand.herta@example.net'),
  ('Fredrick','Klein','merlin02@example.com');

INSERT INTO workshop (workshop_name) VALUES
  ('Spring framework'),
  ('Java Database'),
  ('Java logging and debugging - IDC'),
  ('Java Logging and Debugging - NA');

INSERT INTO workshop_session (workshop_id, speaker_id, attendees_max, workshop_session_start_date, workshop_session_end_date) VALUES
  (1, 1, 5, '2021-01-12 10:00:00', '2021-01-12 11:00:00' ),
  (2, 2, 5, '2021-01-12 13:30:00', '2021-01-12 14:30:00' ),
  (3, 3, 5, '2021-01-13 16:00:00', '2021-01-13 17:00:00' ),
  (4, 4, 5, '2021-01-14 10:00:00', '2021-01-14 11:00:00' );

INSERT INTO workshop_session_attendee (workshop_session_id, attendee_id) VALUES
  (1, 1),
  (1, 2),
  (1, 4),
  (1, 6),
  (1, 7),
  (2, 1),
  (2, 3),
  (2, 4),
  (3, 6),
  (3, 7),
  (3, 8),
  (3, 11),
  (4, 6),
  (4, 7);