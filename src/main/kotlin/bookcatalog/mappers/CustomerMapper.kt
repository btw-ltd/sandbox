package bookcatalog.mappers

import bookcatalog.dao.CustomerDAO
import bookcatalog.dtos.CustomerDTO
import bookcatalog.dtos.EditCustomerDTO

fun CustomerDAO.toDTO() = CustomerDTO(id.value, name)

fun EditCustomerDTO.updateDAO(dao: CustomerDAO) {
    dao.name = name
}