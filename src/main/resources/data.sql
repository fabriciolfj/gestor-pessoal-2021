insert into usuario(id, login, senha, email, nome)
   select nextval('hibernate_sequence'), 'admin', 'admin', 'admin@admin.com.br', 'ADMIN'
    where not exists(select id from usuario where id = 1);