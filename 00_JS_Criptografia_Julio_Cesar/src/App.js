import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
const sha1 = require ('js-sha1');

function App () {
  const alfabeto = {
    a: 'v',
    b: 'w',
    c: 'x',
    d: 'y',
    e: 'z',
    f: 'a',
    g: 'b',
    h: 'c',
    i: 'd',
    j: 'e',
    k: 'f',
    l: 'g',
    m: 'h',
    n: 'i',
    o: 'j',
    p: 'k',
    q: 'l',
    r: 'm',
    s: 'n',
    t: 'o',
    u: 'p',
    v: 'q',
    w: 'r',
    x: 's',
    y: 't',
    z: 'u',
  };

  const [cifrado, setCifrado] = useState ('');
  const [dados, setDados] = useState ({});
  const [dadosDesc, setDadosDesc] = useState ({});
  const [decifrado, setDecifrado] = useState ([]);

  useEffect (
    () => {
      function descifra () {
        let pedacos = [];
        pedacos = [...cifrado.split ('.')];
        console.log ('os pedacoes sao', pedacos[0], 'e', pedacos[1]);
        let junta_pedacos = [];

        pedacos.forEach (pedaco => {
          const frase = [];
          const palavras = pedaco.trim ().split (' ');
          palavras.forEach (palavra => {
            const desc = [];
            const caracteres = palavra.split ('');
            for (let i = 0; i < caracteres.length; i++) {
              const letra = caracteres[i];
              desc.push ([alfabeto[letra]]);
            }
            const res_palavra = desc.join ('');
            frase.push (res_palavra);
          });

          const frase_final = frase.join (' ');
          junta_pedacos.push (frase_final);
        });

        const frase_final = junta_pedacos.join ('. ');

        console.log (frase_final);
        setDecifrado (frase_final.trim ());
        //HASH#####################################
        sha1 (frase_final.trim ());
        //HASH####################################
        console.log (dados);
        const temp = dados;
        temp.decifrado = frase_final.trim ();
        temp.resumo_criptografico = sha1 (frase_final.trim ());

        setDadosDesc (temp);
      }
      descifra ();
    },
    [cifrado]
  );

  useEffect (
    () => {
      console.log (dadosDesc);
    },
    [dadosDesc]
  );

  const getCripto = () => {
    fetch (
      'https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=975a802ea6234dcc4bfb5a5d69e4051019cbe4fd'
    )
      .then (response => {
        return response.json ();
      })
      .then (data => {
        console.log (data);
        setDados (data);
        setCifrado (data.cifrado);
      });
  };

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <button
          type="button"
          style={{width: '100px', height: '50px'}}
          onClick={getCripto}
        >
          Get Criptografia
        </button>
        <form
          action="https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=975a802ea6234dcc4bfb5a5d69e4051019cbe4fd"
          method="post"
          encType="multipart/form-data"
        >
          <label htmlFor="file">Filename: </label>
          <input type="file" name="answer" id="file" />
          <input type="submit" name="submit" value="Submit" />
        </form>
      </header>
    </div>
  );
}

export default App;
