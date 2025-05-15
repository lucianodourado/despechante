export const mpmMenu = [
  { 
    nome: 'Servidores', 
    url: '', 
    icon: 'public',
    submenu: 
      [
        { 
          nome: 'Chegando', 
          url: '/pessoa-chegando-lista', 
          icon: 'trending_up' 
        },
      { 
          nome: 'Saindo', 
          url: '/pessoa-saindo-lista', 
          icon: 'trending_down' 
      }
    ]
  },
  { 
    nome: 'Configurações', 
    url: '/configuracao-lista', 
    icon: 'edit',
    submenu: 
    [
      { 
        nome: 'URLs', 
        url: '/configuracao-lista', 
        icon: 'edit' 
      },
      { 
        nome: 'Tabelas', 
        url: '/configuracao-lista', 
        icon: 'edit' 
      }
    ]
  },
  { 
    nome: 'Relatórios', 
    url: '/relatorios', 
    icon: 'picture_as_pdf' 
  },
  { 
    nome: 'Logs de Erro', 
    url: '/logs', 
    icon: 'message' 
  },
  {
    nome: 'Ajuda', 
    url: '', 
    icon: 'check_circle',
    submenu: 
    [
      { 
        nome: 'Manual', 
        url: '/xxx', 
        icon: 'done_all' 
      },
      { 
        nome: 'Sobre', 
        url: '/sobre', 
        icon: 'edit' 
      }
    ]
  },
  { 
    nome: 'Sair', 
    url: '/logout', 
    icon: 'exit_to_app' 
  }
];