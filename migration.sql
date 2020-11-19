CREATE EXTENSION "uuid-ossp";

INSERT INTO public.authorities
(id_authority, active, create_at, deleted_at,  modified_at, uuid, name)
VALUES(1, true, (select current_timestamp),null, null (select uuid_generate_v4(), 'SUPERADMIN');

INSERT INTO public.authorities
(id_authority, active, create_at, deleted_at, modified_at, uuid, name)
VALUES(2, true, (select current_timestamp), null, null , (select uuid_generate_v4(), 'CUSTOMER');

INSERT INTO public.authorities
(id_authority,active, create_at, deleted_at, modified_at, uuid, name)
VALUES(3, true, (select current_timestamp), null, null , (select uuid_generate_v4(), 'ADMIN');

INSERT INTO public.users
( active, create_at, deleted_at, modified_at, uuid, email, "password", username)
VALUES( true, (select current_timestamp),NULL, null, (select uuid_generate_v4()), 'maiaramartins@gmail.com', '$2a$10$AtGs7FzCL1B68SMr.Ju2VuaBrPTfutLtipTDR2Gt.peI1LC.OFkQ2', 'admin');

INSERT INTO public.user_authorities
(user_uuid, authority_uuid)
VALUES((select uuid from public.users where username='admin'), (select uuid from public.authorities where name='SUPERADMIN'));

