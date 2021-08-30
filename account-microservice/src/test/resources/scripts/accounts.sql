insert into applicant (id, address, city, created_at, date_of_birth, drivers_license, email, first_name, gender, income, last_modified_at, last_name, mailing_address, mailing_city, mailing_state, mailing_zipcode, middle_name, phone, social_security, state, zipcode)
values (1, '123 Address St', 'City', '2021-08-25', '1997-05-03', 'DC123456', 'test_boy@email.com', 'Test', 'MALE', 5500000, '2021-08-25', 'Boy', 'PO Box 123', 'City', 'New York', '12345', 'Dummy', '(888) 555-5555', '555-55-5555', 'New York', '12345');

insert into member (id, membership_id, applicant_id, branch_id)
values (1, '12345678', 1, 1);

insert into user (role, id, enabled, password, username, email, first_name, last_name, phone, member_id)
values ('MEMBER', 1, 1, 'P@ssword123', 'test_boy', null, null, null, null, 1);

insert into account (account_type, id, account_number, balance, status, available_balance, apy,
                     primary_account_holder_id)
values ('CHECKING', 1, '123456789', 100000, 'ACTIVE', 100000, null, 1);

insert into account_holder (member_id, account_id)
values (1, 1);
