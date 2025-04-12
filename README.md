# Documentação da API - Sistema de Personagens e Itens Mágicos

Esta API permite a gestão de personagens e itens mágicos, permitindo funcionalidades como cadastro, listagem, atualização e remoção de personagens, bem como a adição e remoção de itens mágicos de personagens.

## ENDPOINTS PERSONAGEM

## 1. Cadastrar Personagem
**Endpoint:** `POST /personagem`
**Descrição:** Cadastra um novo personagem no sistema.

**Request Body:**
```json
{
  "nome": "Personagem",
  "nomeAventureiro": "Personagem Aventureiro",
  "level": 10,
  "forca": 5,
  "defesa": 5
}
```

## 2. Listar Personagens
**Endpoint:** `GET /personagem`

**Descrição:** Lista personagens.

## 3. Buscar Personagem por ID
**Endpoint:** `GET /personagem/id`

## 4. Listar itens de personagem
**Endpoint:** `GET /personagem/id/itens`

## 5. Listar amuleto do personagem
**Endpoint:** `GET /personagem/id/amuleto`

## 6. Atualizar personagem
**Endpoint:** `PUT /personagem/id`

**Request Body:**
```json
{
  "nome": "Personagem Modificado",
  "nomeAventureiro": "Personagem Aventureiro Modificado",
  "level": 20,
  "forca": 8,
  "defesa": 2
}
```

## 7. Atualizar nome aventureiro do personagem
**Endpoint:** `PUT /personagem/id`

**Request Body:**
``` "Thorin Invencível" ```

## 8. Adicionar item ao personagem
**Endpoint:** `PUT /personagem/id/itens/idItem`

## 9. Deletar personagem
**Endpoint:** `DELETE /personagem/id`

## 10. Deletar item do personagem
**Endpoint:** `DELETE /personagem/id/itens/idItem`

## ENDPOINTS ITEM MÁGICO

## 1. Cadastrar Item Mágico
**Endpoint:** `POST /itens`
**Descrição:** Cadastra um novo personagem no sistema.

**Request Body:**
```json
{
  "nome": "Espada",
  "tipoItem": "ARMA",
  "forca": 3,
  "defesa": 0
}
```
## 2. Listar Itens Mágicos
**Endpoint:** `GET /itens`

## 3. Buscar Item Mágico por ID
**Endpoint:** `GET /itens/id`

## 4. Atualizar Item Mágico
**Endpoint:** `PUT /itens/id`

## 5. Deletar Item Mágico
**Endpoint:** `DELETE /itens/id`
