package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.Fornecedor;

public class FornecedorRepository {

	private final static HashMap<String, Fornecedor> fornecedores = new HashMap<>();

	public List<Fornecedor> GetAll() {
		return new ArrayList<Fornecedor>(fornecedores.values());
	}

	public Fornecedor Get(final String cnpj) {
		return fornecedores.get(cnpj);
	}

	public String Add(final Fornecedor fornecedor) throws Exception {

		if (checkEmail(fornecedor.getEmail()) && checkCnpj(fornecedor.getCnpj())) {
			fornecedores.put(fornecedor.getCnpj(), fornecedor);
			return "Cadastro realizado com sucesso!";
		} else {
			throw new Exception();
		}

	}

	public String Edit(final Fornecedor fornecedor) throws Exception {
		if (checkEmail(fornecedor.getEmail())) {
			fornecedores.remove(fornecedor.getCnpj());
			fornecedores.put(fornecedor.getCnpj(), fornecedor);
			return "Alteração realizada com sucesso!";
		} else {
			throw new Exception();
		}
	}

	public void Delete(final String cnpj) {
		fornecedores.remove(cnpj);
	}

	public boolean checkEmail(String email) throws Exception {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		} else {
			throw new Exception("Email em formato errado!");
		}

	}

	private boolean checkCnpj(String cnpj) throws Exception {
		if (Get(cnpj) != null) {
			throw new Exception("CNPJ já cadastrado");
		}

		return true;
	}
}
