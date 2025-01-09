import requests
import names

def enviar_dados_usuario(nome, email, senha):
    """Envia dados de um usuário para a API especificada.

    Args:
        nome (str): Nome do usuário.
        email (str): Email do usuário.
        senha (str): Senha do usuário.
    """

    url = "http://localhost:8080/usuario/salvar"
    dados = {
        "nome": nome,
        "email": email,
        "senha": senha
    }

    try:
        response = requests.post(url, json=dados)
        response.raise_for_status()  # Lança exceção para status codes de erro
        print("\033[45mDados enviados com sucesso!\033[m")
    except requests.exceptions.RequestException as e:
        print(f"\033[44mErro ao enviar dados: {e}\033[m")

for _ in range(10):
  nome = names.get_full_name()
  email = nome.replace(' ', '').lower() + "@email.com"
  senha =  names.get_full_name().replace(" ", '32')

  enviar_dados_usuario(nome, email, senha)