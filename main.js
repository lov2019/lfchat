const http = require('http');

// 创建服务器并定义路由
/*
const server = http.createServer((req, res) => {
  const { url, method } = req;

  if (url === '/' && method === 'GET') {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Home Page');
  } else if (url === '/about' && method === 'GET') {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('About Page');
  } else {
    res.writeHead(404, { 'Content-Type': 'text/plain' });
    res.end('404 Not Found');
  }
});

server.listen(3000, () => {
  console.log('Server is running on http://localhost:3000');
});
*/
const server = http.createServer((rq, rs) => {
    const { url, method } = rq;
    switch (url) {
        case "/":
            break;
        default:
            rs.writeHead(404, { 'Content-Type': 'text/plain' });
            rs.end("404 Not Found");
    }
}










                                 
