/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.repository;

import javax.transaction.Transactional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import vn.plusplusc.ecommerce.database.model.Role;

/**
*
* @author manhcuong
*/
@Repository
@Transactional
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {
    
}
