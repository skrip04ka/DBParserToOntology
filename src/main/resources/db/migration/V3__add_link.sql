INSERT INTO sub_classes_link (class_id, sub_class_id) VALUES
    (5, 4),
    (5, 6),
    (5, 7);

INSERT INTO disjoint_classes_link (class_id, disjoint_class_id) VALUES
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (2, 3),
    (2, 4),
    (2, 5),
    (3, 4),
    (3, 5),
    (4, 6),
    (4, 7),
    (6, 7);

INSERT INTO inverse_obj_prop_link (obj_prop_id, inverse_obj_prop_id) VALUES
    (1, 2),
    (3, 4),
    (5, 6),
    (7, 8);

INSERT INTO domains_obj_prop_link (obj_prop_id, domains_class_id) VALUES
    (1, 1),
    (3, 2),
    (5, 3),
    (7, 5);

INSERT INTO ranges_obj_prop_link (obj_prop_id, ranges_class_id) VALUES
    (1, 2),
    (3, 3),
    (5, 4),
    (7, 5);

INSERT INTO domains_data_prop_link (data_prop_id, domains_class_id) VALUES
    (1, 2),
    (2, 2),
    (3, 2);

INSERT INTO individuals_types_link (individuals_id, types_class_id) VALUES
    (1, 7),
    (2, 7),
    (3, 6),
    (4, 6),
    (5, 6),
    (6, 4),
    (7, 4),
    (8, 4),
    (9, 4),
    (10, 4),
    (11, 4),
    (12, 3),
    (13, 3),
    (14, 3),
    (15, 3),
    (16, 3),
    (17, 2),
    (18, 2),
    (19, 1);

INSERT INTO link (subject_id, predicate_id, object_id) VALUES
    (1, 8, 4),
    (1, 8, 3),
    (4, 8, 7),
    (4, 8, 6),
    (4, 8, 11),
    (4, 8, 8),
    (3, 8, 7),
    (3, 8, 6),
    (3, 8, 11),
    (3, 8, 8),
    (5, 8, 7),
    (5, 8, 6),
    (5, 8, 11),
    (5, 8, 8),
    (5, 8, 9),
    (5, 8, 10),
    (7, 6, 12),
    (6, 6, 12),
    (8, 6, 12),
    (11, 6, 12),
    (9, 6, 14),
    (12, 4, 17),
    (14, 4, 18),
    (17, 2, 19),
    (18, 2, 19);

INSERT INTO data_property_value (individuals_id, data_prop_id, value) VALUES
    (18, 1, '7.5'),
    (18, 2, 'Low'),
    (18, 3, 'Network'),
    (19, 1, '7.5'),
    (19, 2, 'Low'),
    (19, 3, 'Network');







