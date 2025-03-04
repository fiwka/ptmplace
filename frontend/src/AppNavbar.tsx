import {DarkThemeToggle, Navbar} from "flowbite-react";

export default function AppNavbar() {
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
                <Navbar.Link href="#" active>
                    Главная
                </Navbar.Link>
                <Navbar.Link href="#">
                    Мои билеты
                </Navbar.Link>
                <Navbar.Link href="#">Маршруты</Navbar.Link>
            </Navbar.Collapse>
        </Navbar>
    )
}