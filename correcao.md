# Correção

## Diagrama

- algumas multiplicidades ausentes
- setas erradas
  - App 'possui' uma InterfaceUsuario, mas a seta usada é de herança
  - mesma situação entre InterfaceUsuario e FormaGeometrica
- InterfaceUsuario possui todos os membros duplicados

## Implementação

- as indicações de onde o polimorfismo é usado estão quase certas...
- ... mas o ideal seria, por exemplo, em InterfaceUsuario linha 233
- pois o polimorfimo permite delegar a execução de um método para a versão concreta...
- ... enquanto usamos a referência da versão abstrata

## Requisitos funcionais

- [x] Impressão com o mouse
- [x] Seleção de figuras
- [x] Seleção de cores
- [x] Seleção de modo
- [x] Seleção de tamanho
- [x] Movimento
- [x] Limpeza
- [x] Processamento

## Nota

10



