OOP Java assignments 1-4: Event Management.

SQL query:
```sql
CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    max_capacity INT NOT NULL,
    start_time TIMESTAMP NOT NULL,
    
    event_type VARCHAR(31) NOT NULL,
    
    location VARCHAR(255),
    platform_url VARCHAR(255)
);

CREATE TABLE participants (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE event_enrollments (
    event_id INT REFERENCES events(id) ON DELETE CASCADE,
    participant_id INT REFERENCES participants(id) ON DELETE CASCADE,
    PRIMARY KEY (event_id, participant_id)
);
```
