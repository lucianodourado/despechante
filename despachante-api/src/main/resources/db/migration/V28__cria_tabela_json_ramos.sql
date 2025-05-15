CREATE TABLE [dbo].PESSOA_REMOVIDA_JSON (
	[id] bigint primary key identity,	
	cpf varchar(11) NOT NULL,    
	matricula numeric(25,2) NOT NULL,
	nome varchar(100) NOT NULL,
	dataNascimento datetime2 NOT NULL,				
    pessoaRemovidaCompleto nvarchar(max) CHECK(
        ISJSON(pessoaRemovidaCompleto) = 1
    )    
);
