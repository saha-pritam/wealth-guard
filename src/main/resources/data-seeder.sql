-- 1. Clear existing procedure if rerunning
DROP PROCEDURE IF EXISTS SeedWealthGuardData $$

CREATE PROCEDURE SeedWealthGuardData()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE p_id INT;
    DECLARE a_id INT;

    -- 2. Generate 100 Owners and 100 Portfolios (One-to-One)
    WHILE i <= 100 DO
        -- Insert Owner (Using padded sequences for constraints to avoid real PII)
        INSERT INTO owner (aadhar, first_name, last_name, pan, mobile, email)
        VALUES (
            LPAD(i, 12, '0'),
            CONCAT('UserFirst', i),
            CONCAT('UserLast', i),
            CONCAT('PAN', LPAD(i, 7, '0')),
            CAST(1000000000 + i AS CHAR),
            CONCAT('investor', i, '@wealthguard.com')
        );

        -- Insert corresponding Portfolio
INSERT INTO portfolio (owner_id) VALUES (i);

SET i = i + 1;
END WHILE;

    -- 3. Generate 1,000 Assets with Subclasses
    SET i = 1;
    WHILE i <= 1000 DO
        -- Base Asset Entry
        INSERT INTO asset (name, ticker, current_nav)
        VALUES (CONCAT('Asset Fund ', i), CONCAT('TKR', i), ROUND(RAND() * 1000 + 10, 4));

        -- Distribute polymorphically: 300 ETFs, 400 Mutual Funds, 300 Debentures
        IF i <= 300 THEN
            INSERT INTO exchange_traded_fund (id, exchange, tracking_error)
            VALUES (i, IF(i % 2 = 0, 'NSE', 'BSE'), ROUND(RAND() * 0.05, 4));

        ELSEIF i <= 700 THEN
            INSERT INTO mutual_fund (id, fund_category, expense_ratio, exit_load)
            VALUES (i, IF(i % 2 = 0, 'SMALL_CAP', 'MID_CAP'), ROUND(RAND() * 1.5, 4), 1.0000);

ELSE
            INSERT INTO debenture (id, coupon_rate, maturity_date)
            VALUES (i, ROUND(RAND() * 5 + 6, 4), DATE_ADD(CURDATE(), INTERVAL (i % 10) YEAR));
END IF;

        SET i = i + 1;
END WHILE;

    -- 4. Generate 10,000 Portfolio Holdings (Trades)
    SET i = 1;
    WHILE i <= 10000 DO
        -- Pick a random portfolio (1-100) and random asset (1-1000)
        SET p_id = FLOOR(RAND() * 100) + 1;
        SET a_id = FLOOR(RAND() * 1000) + 1;

INSERT INTO portfolio_holding (portfolio_id, asset_id, quantity, average_buy_price)
VALUES (
           p_id,
           a_id,
           ROUND(RAND() * 500 + 10, 4),  -- Random quantity between 10 and 510
           ROUND(RAND() * 1000 + 10, 4)  -- Random buy price
       );

SET i = i + 1;
END WHILE;

END$$

-- Execute the procedure immediately upon application startup
CALL SeedWealthGuardData();