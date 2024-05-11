package com.example.restobar.services;

import com.example.restobar.models.Base;
import com.example.restobar.repositories.BaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

//clase abstracta de implementacion de un servicio, se le pasa por parametro una entidad E que extiende de Base en el paquete modelo
//un ID serializable que puede tomar cualquier tipo de dato, y tambien implementa la interfaz BaseService y le paso por parametros E y ID
public abstract class BaseServiceImple <E extends Base, ID extends Serializable> implements BaseService<E, ID>{
    protected BaseRepository<E,ID> baseRepository;

    public BaseServiceImple(BaseRepository<E,ID> baseRepository){
        this.baseRepository = baseRepository;
    }
    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try{
            List<E> entityFindAll = baseRepository.findAll();
            return entityFindAll;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity = baseRepository.save(entity);
            return entity;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public E update(ID id, E updatedEntity) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            if (entityOptional.isPresent()) {
                E entityToUpdate = entityOptional.get();

                // Obtener la clase de la entidad
                Class<?> entityClass = entityToUpdate.getClass();

                // Obtener los campos de la entidad
                Field[] fields = entityClass.getDeclaredFields();

                // Iterar sobre los campos y actualizar los valores si se proporcionaron en updatedEntity
                for (Field field : fields) {
                    // Establecer el campo como accesible
                    field.setAccessible(true);

                    // Obtener el nombre del campo
                    String fieldName = field.getName();

                    // Obtener el valor del campo en updatedEntity
                    Field updatedField;
                    try {
                        updatedField = updatedEntity.getClass().getDeclaredField(fieldName);
                        updatedField.setAccessible(true);
                    } catch (NoSuchFieldException e) {
                        // El campo no está presente en updatedEntity, continuar con el siguiente campo
                        continue;
                    }

                    // Obtener el valor del campo en updatedEntity
                    Object updatedValue = updatedField.get(updatedEntity);

                    // Si el valor no es nulo, establecerlo en entityToUpdate
                    if (updatedValue != null) {
                        field.set(entityToUpdate, updatedValue);
                    }
                }

                // Guardar la entidad actualizada en el repositorio
                entityToUpdate = baseRepository.save(entityToUpdate);
                return entityToUpdate;
            } else {
                // Si no se encuentra la entidad con el ID proporcionado, lanzar una excepción o devolver null
                throw new EntityNotFoundException("No se encontró la entidad con el ID: " + id);
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar la entidad: " + e.getMessage());
        }
    }
   /* @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            E entityUpdate= entityOptional.get();
            entityUpdate = baseRepository.save(entity);
            return entityUpdate;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
*/
    @Override
    @Transactional
    public Boolean delete(ID id) throws Exception {
        try{
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
