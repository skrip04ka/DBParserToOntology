-- classes
CREATE TABLE classes (
    class_id serial PRIMARY KEY,
    title varchar(100)
);

CREATE TABLE sub_classes_link (
    link_id serial PRIMARY KEY,
    class_id INT,
    sub_class_id INT,
    FOREIGN KEY (class_id) REFERENCES classes (class_id),
    FOREIGN KEY (sub_class_id) REFERENCES classes (class_id)
);

CREATE TABLE disjoint_classes_link (
    link_id serial PRIMARY KEY,
    class_id INT,
    disjoint_class_id INT,
    FOREIGN KEY (class_id) REFERENCES classes (class_id),
    FOREIGN KEY (disjoint_class_id) REFERENCES classes (class_id)
);

-- obj_prop
CREATE TABLE object_properties (
    obj_prop_id serial PRIMARY KEY,
    title varchar(100),
    functional BOOLEAN DEFAULT False,
    inv_functional BOOLEAN DEFAULT False,
    transitive BOOLEAN DEFAULT False,
    sym BOOLEAN DEFAULT False,
    asym BOOLEAN DEFAULT False,
    reflexive BOOLEAN DEFAULT False,
    irreflexive BOOLEAN DEFAULT False
);

CREATE TABLE sub_obj_prop_link (
    link_id serial PRIMARY KEY,
    obj_prop_id INT,
    sub_obj_prop_id INT,
    FOREIGN KEY (obj_prop_id) REFERENCES object_properties (obj_prop_id),
    FOREIGN KEY (sub_obj_prop_id) REFERENCES object_properties (obj_prop_id)
);

CREATE TABLE disjoint_obj_prop_link (
    link_id serial PRIMARY KEY,
    obj_prop_id INT,
    disjoint_obj_prop_id INT,
    FOREIGN KEY (obj_prop_id) REFERENCES object_properties (obj_prop_id),
    FOREIGN KEY (disjoint_obj_prop_id) REFERENCES object_properties (obj_prop_id)
);

CREATE TABLE inverse_obj_prop_link (
    link_id serial PRIMARY KEY,
    obj_prop_id INT,
    inverse_obj_prop_id INT,
    FOREIGN KEY (obj_prop_id) REFERENCES object_properties (obj_prop_id),
    FOREIGN KEY (inverse_obj_prop_id) REFERENCES object_properties (obj_prop_id)
);

CREATE TABLE domains_obj_prop_link (
    link_id serial PRIMARY KEY,
    obj_prop_id INT,
    domains_class_id INT,
    FOREIGN KEY (obj_prop_id) REFERENCES object_properties (obj_prop_id),
    FOREIGN KEY (domains_class_id) REFERENCES classes (class_id)
);

CREATE TABLE ranges_obj_prop_link (
    link_id serial PRIMARY KEY,
    obj_prop_id INT,
    ranges_class_id INT,
    FOREIGN KEY (obj_prop_id) REFERENCES object_properties (obj_prop_id),
    FOREIGN KEY (ranges_class_id) REFERENCES classes (class_id)
);


-- data_prop
CREATE TABLE data_properties (
    data_prop_id serial PRIMARY KEY,
    title varchar(100),
    type varchar(100) DEFAULT 'xsd:string',
    functional BOOLEAN DEFAULT False
);

CREATE TABLE domains_data_prop_link (
    link_id serial PRIMARY KEY,
    data_prop_id INT,
    domains_class_id INT,
    FOREIGN KEY (data_prop_id) REFERENCES data_properties (data_prop_id),
    FOREIGN KEY (domains_class_id) REFERENCES classes (class_id)
);


-- individuals
CREATE TABLE individuals (
    individuals_id serial PRIMARY KEY,
    title varchar(100),
    functional BOOLEAN DEFAULT False
);

CREATE TABLE individuals_types_link (
    link_id serial PRIMARY KEY,
    individuals_id INT,
    types_class_id INT,
    FOREIGN KEY (individuals_id) REFERENCES individuals (individuals_id),
    FOREIGN KEY (types_class_id) REFERENCES classes (class_id)
);

CREATE TABLE link (
    link_id serial PRIMARY KEY,
    subject_id INT,
    predicate_id INT,
    object_id INT,
    FOREIGN KEY (subject_id) REFERENCES individuals (individuals_id),
    FOREIGN KEY (predicate_id) REFERENCES object_properties (obj_prop_id),
    FOREIGN KEY (object_id) REFERENCES individuals (individuals_id)
);

CREATE TABLE data_property_value (
    data_property_value serial PRIMARY KEY,
    individuals_id INT,
    data_prop_id INT,
    FOREIGN KEY (individuals_id) REFERENCES individuals (individuals_id),
    FOREIGN KEY (data_prop_id) REFERENCES data_properties (data_prop_id),
    value varchar(100)
);