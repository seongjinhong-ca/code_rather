--create database rather;

--create table code_snippet
create table code_snippet(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    code text NOT NULL,
    PRIMARY KEY (id)
);

create table ranking(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    picked_code_snippet_id uuid NOT NULL,
    not_picked_code_snippet_id uuid NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT "picked_and_not_picked_are_different"
        check (picked_code_snippet_id <> not_picked_code_snippet_id),
    FOREIGN KEY (picked_code_snippet_id)
        references code_snippet (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
    FOREIGN KEY (not_picked_code_snippet_id)
        references code_snippet(id) ON UPDATE RESTRICT ON DELETE RESTRICT
);