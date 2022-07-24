CREATE TABLE IF NOT EXISTS tasks (
    id VARCHAR(50) AUTO_INCREMENT
  , kind_id INT NOT NULL -- 0：仕事、１：勉強、２：その他
  , name VARCHAR(50) NOT NULL
  , entry_date DATE NOT NULL
  , complete_date DATE
  , condition_id INT NOT NULL -- 0:未完、1:完了、2：着手中、３：削除
  , PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS logs (
	log_id VARCHAR(50) AUTO_INCREMENT
	, id VARCHAR(50)
	, name VARCHAR(50) NOT NULL
  , condition_id int NOT NULL -- 0:未完、1:完了、2：着手中、３：削除
  , update_date DATE NOT NULL
	, memo VARCHAR(500)
	, PRIMARY KEY(log_id)
);

CREATE TABLE IF NOT EXISTS kinds (
	kind_id INT NOT NULL  -- 0：仕事、１：勉強、２：その他
	, kind VARCHAR(50)
	, PRIMARY KEY(kind_id)
);

CREATE TABLE IF NOT EXISTS conditions (
	condition_id INT NOT NULL -- 0:未完、1:完了、2：着手中、３：削除
	, condition VARCHAR(50)
	, PRIMARY KEY(condition_id)
);
