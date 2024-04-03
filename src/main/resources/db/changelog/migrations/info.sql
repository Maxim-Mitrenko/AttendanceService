create TABLE info(
    userID bigint,
    class_name varchar(3),
    day date,
    start_lesson int,
    end_lesson int,
    reason varchar(255),
    PRIMARY KEY (userID, day)
)