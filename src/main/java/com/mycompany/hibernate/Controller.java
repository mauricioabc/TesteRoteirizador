package com.mycompany.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;
import org.hibernate.Session;

public class Controller {

    public Controller() {
    }
    
    public void salvarProduto(Produto produto) {
        // Inicializa o EntityManager do Hibernate
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Inicia a transação
        entityManager.getTransaction().begin();

        // Persiste o objeto Produto no banco de dados
        entityManager.persist(produto);

        // Confirma a transação
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
        entityManagerFactory.close();
    }
    
        public void editarProduto(String nomeProduto, double novoPreco) {
        // Inicializa o EntityManager do Hibernate
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            // Busca o produto pelo nome
            Query query = entityManager.createQuery("SELECT p FROM Produto p WHERE p.nome = :nome");
            query.setParameter("nome", nomeProduto);
            Produto produto = (Produto) query.getSingleResult();

            // Atualiza o preço do produto
            produto.setPreco(novoPreco);

            // Salva as alterações no banco de dados
            entityManager.merge(produto);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    
}
