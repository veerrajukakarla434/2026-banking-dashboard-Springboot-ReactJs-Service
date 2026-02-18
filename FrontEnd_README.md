# Front End Project

🚀 Step 1: Create the Project

````text
npm create vite@latest banking-frontend -- --template react-ts
cd banking-frontend
npm install

-----

npm install axios @reduxjs/toolkit react-redux react-router-dom
npm install -D @types/react @types/react-dom
```

---

## 📁 Step 2: Folder Structure

Create this structure inside `src/`:
```
src/
├── api/
│   ├── axiosInstance.ts
│   ├── accountApi.ts
│   └── transferApi.ts
├── components/
│   ├── layout/
│   │   ├── Sidebar.tsx
│   │   └── Topbar.tsx
│   ├── dashboard/
│   │   ├── BalanceCard.tsx
│   │   ├── BalanceChart.tsx
│   │   └── TransactionList.tsx
│   ├── transfer/
│   │   ├── TransferForm.tsx
│   │   └── ConfirmModal.tsx
│   └── ui/
│       ├── Button.tsx
│       └── Input.tsx
├── pages/
│   ├── DashboardPage.tsx
│   └── TransferPage.tsx
├── store/
│   ├── index.ts
│   ├── accountSlice.ts
│   └── transferSlice.ts
├── theme/
│   └── tokens.ts
├── types/
│   └── index.ts
├── App.tsx
└── main.tsx



```
