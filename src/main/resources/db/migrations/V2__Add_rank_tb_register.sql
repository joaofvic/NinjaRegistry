-- V2: Migrations to add column RANK
ALTER TABLE tb_register
ADD COLUMN rank VARCHAR(255);