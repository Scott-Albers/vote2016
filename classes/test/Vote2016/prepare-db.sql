use vote2016;

set FOREIGN_KEY_CHECKS = 0;
truncate table voters;
truncate table candidates;
truncate table states;
truncate table candidate_voter;
set FOREIGN_KEY_CHECKS = 1;


INSERT INTO `vote2016`.`states` (`id`, `version`, `name`, `elect_votes`, `created_at`, `updated_at`) VALUES ('1', '1', 'Illinois', '20', '2016-08-25', '2016-08-25');
INSERT INTO `vote2016`.`states` (`id`, `version`, `name`, `elect_votes`, `created_at`, `updated_at`) VALUES ('2', '1', 'Alabama', '9', '2016-08-25', '2016-08-25');
INSERT INTO `vote2016`.`states` (`id`, `version`, `name`, `elect_votes`, `created_at`, `updated_at`) VALUES ('3', '1', 'Alaska', '3', '2016-08-25', '2016-08-25');
INSERT INTO `vote2016`.`states` (`id`, `version`, `name`, `elect_votes`, `created_at`, `updated_at`) VALUES ('4', '1', 'Arizona', '11', '2016-08-25', '2016-08-25');

INSERT INTO `vote2016`.`voters` (`version`, `name`, `age`, `gender`, `ethnicity`, `created_at`, `updated_at`, `state_id2`) VALUES ('0', 'Scott', '18', 'M', 'Other', '2016-8-25', '2016-8-25',1);
INSERT INTO `vote2016`.`voters` (`version`, `name`, `age`, `gender`, `ethnicity`, `created_at`, `updated_at`, `state_id2`) VALUES ('0', 'Bal', '19', 'M', 'Other', '2016-8-25', '2016-8-25', 1);
INSERT INTO `vote2016`.`voters` (`version`, `name`, `age`, `gender`, `ethnicity`, `created_at`, `updated_at`, `state_id2`) VALUES ('0', 'Sue', '21', 'F', 'Other', '2016-8-25', '2016-8-25', 1);
INSERT INTO `vote2016`.`voters` (`version`, `name`, `age`, `gender`, `ethnicity`, `created_at`, `updated_at`, `state_id2`) VALUES ('0', 'Jane', '22', 'F', 'Other', '2016-8-25', '2016-8-25', 1);

INSERT INTO `vote2016`.`candidates` (`version`, `name`, `position`, `party`, `state_id`, `created_at`, `updated_at`) VALUES ('0', 'Hillary', 'President', 'Democrat', '1', '2016-08-24', '2016-08-24');
INSERT INTO `vote2016`.`candidates` (`version`, `name`, `position`, `party`, `state_id`, `created_at`, `updated_at`) VALUES ('0', 'Donald', 'President', 'Republican', '2', '2016-08-24', '2016-08-24');
INSERT INTO `vote2016`.`candidates` (`version`, `name`, `position`, `party`, `state_id`, `created_at`, `updated_at`) VALUES ('0', 'Joe', 'Governor', 'Democrat', '1', '2016-08-24', '2016-08-24');
INSERT INTO `vote2016`.`candidates` (`version`, `name`, `position`, `party`, `state_id`, `created_at`, `updated_at`) VALUES ('0', 'Sally', 'Governor', 'Republican', '1', '2016-08-24', '2016-08-24');
INSERT INTO `vote2016`.`candidates` (`version`, `name`, `position`, `party`, `state_id`, `created_at`, `updated_at`) VALUES ('0', 'Henry', 'Senator', 'Democrat', '1', '2016-08-24', '2016-08-24');
INSERT INTO `vote2016`.`candidates` (`version`, `name`, `position`, `party`, `state_id`, `created_at`, `updated_at`) VALUES ('0', 'Chris', 'Senator', 'Republican', '1', '2016-08-24', '2016-08-24');

INSERT INTO `vote2016`.`candidate_voter` (`candidate_id`, `voter_id`)
VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 4)
