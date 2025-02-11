import Header from "./Header.jsx";
import Nav from "./Nav.jsx";
import Main2 from "./Main2.jsx";
import Footer from "./Footer.jsx";

export default function Wrap() {
  return (
    <div className="flex flex-col bg-cyan-400 w-auto h-auto p-5 gap-2">
      <Header />
      <Nav />
      <Main2 />
      <Footer />
    </div>
  );
}
