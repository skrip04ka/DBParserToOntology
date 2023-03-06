INSERT INTO classes (title) VALUES
    ('component'),
    ('vulnerability'),
    ('cybehreesis'),
    ('result_cybehreesis'),
    ('result'),
    ('effect'),
    ('after-effect');

INSERT INTO object_properties (title, asym) VALUES
    ('has', True),
    ('present_in', True),
    ('create', True),
    ('is_create', True),
    ('determines', True),
    ('depends_on', True);

INSERT INTO object_properties (title, asym, transitive) VALUES
    ('leads_to', True, True),
    ('is_caused', True, True);

-- after-effect
INSERT INTO individuals (title) VALUES
    ('turning_off_equipment'), -- отключение оборудования 1
    ('equipment_damage'); -- повреждение оборудования 2

-- effect
INSERT INTO individuals (title) VALUES
    ('false_operation'), -- ложое срабатывание 3
    ('excessive_operation'), -- излишнее срабатывание 4
    ('refusal_operation'); -- отказ срабатывания 5

-- result_cybehreesis
INSERT INTO individuals (title) VALUES
    ('replacement_configuration'), -- подмена конфигурации 6
    ('firmware_replacement'), -- подмена прошивки 7
    ('introduction_malicious_software'), -- внедрение вредоносного ПО 8
    ('way_out_order'), -- выход из строя 9
    ('removing_firmware'), -- удаление прошивки 10
    ('replacing_signal_operation'); -- подмена сигнала срабатывания 11

-- cybehreesis
INSERT INTO individuals (title) VALUES
    ('data_substitution'), -- подмена данных 12
    ('resource_exhaustion'), -- истощение ресурсов 13
    ('refusal_maintenance'), -- отказ в обслуживании 14
    ('information_leak'), -- утечка информации 15
    ('code_execution'); -- исполнение кода 16

-- vulnerability
INSERT INTO individuals (title) VALUES
    ('CVE-2019-10930'), -- 17
    ('CVE-2019-10931'); -- 18

-- component
INSERT INTO individuals (title) VALUES
    ('IED1'); -- 19


INSERT INTO data_properties (title, type) VALUES
    ('CVSS', 'xsd:double');

INSERT INTO data_properties (title) VALUES
    ('Complexity'),
    ('Access');