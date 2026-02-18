# Project Setup

```sql

🗄️ Step 1: Database Setup
First, create your PostgreSQL database:

createdb bankingdb

Then run this schema:

-- schema.sql
CREATE TABLE users (
    id          SERIAL PRIMARY KEY,
    full_name   VARCHAR(100) NOT NULL,
    email       VARCHAR(100) UNIQUE NOT NULL,
    created_at  TIMESTAMP DEFAULT NOW()
);

CREATE TABLE accounts (
    id              SERIAL PRIMARY KEY,
    user_id         INTEGER REFERENCES users(id) ON DELETE CASCADE,
    account_number  VARCHAR(20) UNIQUE NOT NULL,
    account_type    VARCHAR(20) NOT NULL,
    balance         NUMERIC(15, 2) DEFAULT 0.00,
    currency        VARCHAR(5) DEFAULT 'USD',
    created_at      TIMESTAMP DEFAULT NOW()
);

CREATE TABLE transactions (
    id                SERIAL PRIMARY KEY,
    from_account_id   INTEGER REFERENCES accounts(id),
    to_account_id     INTEGER REFERENCES accounts(id),
    amount            NUMERIC(15, 2) NOT NULL,
    type              VARCHAR(20) NOT NULL,
    description       VARCHAR(255),
    status            VARCHAR(20) DEFAULT 'SUCCESS',
    created_at        TIMESTAMP DEFAULT NOW()
);

-- Seed data
INSERT INTO users (full_name, email) VALUES ('Alex Morgan', 'alex@bank.com');
INSERT INTO accounts (user_id, account_number, account_type, balance)
VALUES (1, 'ACC-001-2024', 'CHECKING', 12450.75),
       (1, 'ACC-002-2024', 'SAVINGS', 48200.00);

```


<img width="679" height="355" alt="image" src="https://github.com/user-attachments/assets/08a29aa0-07b5-4999-bdb7-44f3335c83a6" />


