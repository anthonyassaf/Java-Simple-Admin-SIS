/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DTO.IDTO;
import java.util.ArrayList;

/**
 *
 * @author anthony
 */
public interface IRepo {
    public IDTO get(int id);

    public boolean update(IDTO dto);

    public ArrayList<IDTO> getAll();

    public boolean create(IDTO dto);

    public boolean delete(int id);

    public boolean destroy();
}
