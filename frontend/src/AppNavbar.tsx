import {DarkThemeToggle, Navbar} from "flowbite-react";
import {useLocation} from "react-router";

export default function AppNavbar() {
    const location = useLocation()

    return (
        <Navbar>
            <Navbar.Brand href="https://flowbite-react.com">
                <img src="/ptmplace.svg" className="mr-3 h-6 sm:h-9" alt="ptmplace Logo"/>
                <span
                    className="self-center whitespace-nowrap text-xl font-semibold dark:text-white">ptmplace</span>
            </Navbar.Brand>
            <div className="flex md:order-2">
                <DarkThemeToggle />
                <Navbar.Toggle/>
            </div>
            <Navbar.Collapse>
                <Navbar.Link href="/" active={location.pathname == '/'}>
                    Главная
                </Navbar.Link>
                <Navbar.Link href="/tickets" active={location.pathname == '/tickets'}>
                    Мои билеты
                </Navbar.Link>
                <Navbar.Link href="/cities" active={location.pathname == '/cities'}>
                    Города
                </Navbar.Link>
            </Navbar.Collapse>
        </Navbar>
    )
}