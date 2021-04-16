import LeftMenu from "./components/LeftMenu"
import MainBox from "./components/MainBox"
import Header from "./components/Header"
import React, { useEffect } from "react"
import "./index.css"

function App() {
  const [feature, setFeature] = React.useState(1);

  const handleFeatureClick = (e) => {
    setFeature(e)
  }

  return (
    <div class="grid-container">
      <header class="header">
        <Header>
        </Header>
      </header>
      <aside class="sidenav">
        <LeftMenu onClick={(e) => handleFeatureClick(e)} ></LeftMenu>
      </aside>
      <main class="main">
        <MainBox feature={feature}></MainBox>
      </main>
    </div>
  );
}

export default App;
