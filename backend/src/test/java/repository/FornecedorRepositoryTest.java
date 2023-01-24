package repository;

import entities.Fornecedor;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;

public class FornecedorRepositoryTest {

    @Test
    public void checkEmail() throws Exception {
        String email = "teste@gmail.com";
        FornecedorRepository fornecedorRepository = new FornecedorRepository();
        boolean isValid = fornecedorRepository.checkEmail(email);

        Assert.assertTrue(isValid);

    }
}
