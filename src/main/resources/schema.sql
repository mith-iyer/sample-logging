DROP TABLE IF EXISTS attendee_signup;
DROP TABLE IF EXISTS workshop_session;
DROP TABLE IF EXISTS workshop;
DROP TABLE IF EXISTS attendee;
DROP TABLE IF EXISTS speaker;

CREATE TABLE speaker (
  speaker_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) DEFAULT NULL
);

CREATE TABLE attendee (
  attendee_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) DEFAULT NULL
);

CREATE TABLE workshop (
  workshop_id INT AUTO_INCREMENT PRIMARY KEY,
  workshop_name VARCHAR(250) NOT NULL
);

CREATE TABLE workshop_session (
  workshop_session_id INT AUTO_INCREMENT PRIMARY KEY,
  workshop_id INT NOT NULL,
  speaker_id INT NOT NULL,
  attendees_max INT DEFAULT 0,
  workshop_session_start_date TIMESTAMP NOT NULL,
  workshop_session_end_date TIMESTAMP NOT NULL,
  CONSTRAINT FK_WORKSHOP_SESSIONS_WORKSHOPS FOREIGN KEY (workshop_id) REFERENCES workshop ON DELETE CASCADE,
  CONSTRAINT FK_WORKSHOP_SESSIONS_SPEAKERS FOREIGN KEY (speaker_id) REFERENCES speaker ON DELETE CASCADE
);

CREATE TABLE workshop_session_attendee (
  workshop_session_attendee_id INT AUTO_INCREMENT PRIMARY KEY,
  workshop_session_id INT NOT NULL,
  attendee_id INT NOT NULL,
  CONSTRAINT FK_ATTENDEE_SIGNUP_WORKSHOP FOREIGN KEY (workshop_session_id) REFERENCES workshop_session ON DELETE CASCADE,
  CONSTRAINT FK_ATTENDEE_SIGNUP_ATTENDEE FOREIGN KEY (attendee_id) REFERENCES attendee ON DELETE CASCADE
);

