INSERT INTO tasks (kind_id, name, entry_date, complete_date, condition_id) values (1 , 'Progate SQL', '2022-04-05', '2022-04-08', 1);
INSERT INTO tasks (kind_id, name, entry_date, complete_date, condition_id) values (1 , 'HTML 19.5-5', '2022-04-05', null, 2);
INSERT INTO tasks (kind_id, name, entry_date, complete_date, condition_id) values (2 , '１００億稼ぐ', '2022-03-05', null, 3);
INSERT INTO tasks (kind_id, name, entry_date, complete_date, condition_id) values (0 , 'ホテル予約', '2022-04-07', null, 0);


-- 0：仕事、１：勉強、２：その他
INSERT INTO kinds (kind_id, kind) values (0, '仕事');
INSERT INTO kinds (kind_id, kind) values (1, '勉強');
INSERT INTO kinds (kind_id, kind) values (2, 'その他');

-- 0:未完、1:完了、2：着手中、３：削除
INSERT INTO conditions (condition_id, condition) values (0, '未完');
INSERT INTO conditions (condition_id, condition) values (1, '完了');
INSERT INTO conditions (condition_id, condition) values (2, '着手中');
INSERT INTO conditions (condition_id, condition) values (3, '削除');

INSERT INTO logs (id, name, condition_id, update_date, memo) values (1, 'Progate SQL', 0, '2022-04-06', '頑張るマン親切マン');
INSERT INTO logs (id, name, condition_id, update_date, memo) values (1, 'Progate SQL', 2, '2022-04-07', 'ヤッターマン');
INSERT INTO logs (id, name, condition_id, update_date, memo) values (1, 'Progate SQL', 2, '2022-04-07', '進捗がんばれ');
INSERT INTO logs (id, name, condition_id, update_date, memo) values (2, 'HTML19.5', 2, '2022-04-07', '難しくて進んでない');