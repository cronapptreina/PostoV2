package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("AnoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface AnoDAO extends JpaRepository<Ano, java.lang.String> {

  /**
   * Obtém a instância de Ano utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Ano entity WHERE entity.id = :id")
  public Ano findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Ano utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Ano entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Carro entity WHERE entity.ano.id = :id")
  public Page<Carro> findCarro(@Param(value="id") java.lang.String id, Pageable pageable);

}
