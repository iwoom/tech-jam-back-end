create database IF NOT EXISTS td_db;

use td_db;


CREATE TABLE IF NOT EXISTS donation_history(
	           id INT AUTO_INCREMENT PRIMARY KEY,
		           currencyAmount FLOAT,
			           customerId VARCHAR(255) NOT NULL,
				           merchantId VARCHAR(255) NOT NULL,
					           merchantName VARCHAR(255) NOT NULL,
						           trans_date TIMESTAMP
							        );
