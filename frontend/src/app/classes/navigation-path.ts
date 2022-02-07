export enum NavigationPath {
    LOGIN = "login",
    REGISTRATION = "registration",
    MAIN = "main",
    SUPPLIES = "supplies",
    PURCHASES = "purchases",
    REPORTS = "reports",
    USERS = "users",
    PROFILE = "profile",
    INFORMATION = "information",
    SALES = "sales",
    ORDERS = "orders",
    PASSWORD = "password",
    CHANGE_PASSWORD = "password/change"
}

export const getFirstUrlToken: (url: string) => string = (url: string): string =>
    url.replace(/^\//, "").replace(/\/.*$/, "")
